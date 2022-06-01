let hostName = 'localhost';

let registerCard = new Vue({
    el: "#register-card",
    data: {
        msg: "message",
        show_stu_form: 0,
        show_tea_form: 0,
        sex: "",
        sex_message: "",
        cSex: "",
        sexCode: 0,
        trole: {
            msg: "",
            roleClass: ""
        },
        nameMsg: {
            msg: "",
            nClass: ""
        },
        idMsg: {
            msg: "",
            iClass: ""
        },
        stu: {
            sname: "",
            id: "",
            collid: "",
            sori: "",
            sex: ""
        },
        teacher: {
            name: "",
            id: "",
            trole: "",
            collegeId: "",
            sex: ""
        }
    },
    methods: {
        click_role_tea: function () {
            this.show_stu_form = 0;
            this.show_tea_form = 1;
        },
        click_role_stu: function () {
            this.show_tea_form = 0;
            this.show_stu_form = 1;
        },
        checkSubmit: function () {
            var flag = true;

            if (this.sexCode == 0) {
                this.sex_message = '请输入正确性别..male or female';
                this.cSex = 'text-danger';
                flag = false;
            }

            if ((this.stu.sname == '' && this.show_stu_form) || (this.teacher.name == '' && this.show_tea_form == 1)) {
                this.nameMsg.msg = '请输入姓名';
                this.nameMsg.nClass = 'text-danger';
                flag = false;
            }
            if ((this.show_stu_form == 1 && this.stu.id == '') || (this.show_tea_form == 1 && this.teacher.id == '')) {
                this.idMsg.msg = "请输入ID";
                this.idMsg.iClass = 'text-danger';
                flag = false;
            }
            if (this.teacher.trole == '' && this.show_tea_form == 1) {
                this.trole.msg = '请选择教师角色';
                this.trole.roleClass = 'text-danger'
                flag = false;
            }

            if (flag == false) return flag;

            if (this.show_stu_form == 1) {
                axios.post("http://"+hostName+":30/students/register", this.stu)
                    .then(function(response){
                        //请求成功
                        if (response.status == 200) {
                            /*跳转到登录页面*/
                            window.location.href = "http://"+hostName+":30/pages-login.html";
                        }
                     })
                    .catch(function (error){
                        //注册失败
                        alert("注册失败，请重新注册");
                        window.location.href = "http://"+hostName+":30/pages-register.html";
                    });

            } else {
                axios.post("http://"+hostName+":30/teachers/register", this.teacher)
                    .then(function (response) {
                        //请求成功
                        if (response.status == 200) {
                            /*跳转到登录页面*/
                            window.location.href = "http://"+hostName+":30/pages-login.html";
                        }
                    }, function (error) {
                        alert("注册失败，请重新注册");
                        window.location.href = "http://"+hostName+":30/pages-register.html";
                    })
            }

        },
        detectSex: function () {
            if (this.stu.sex == "male" || this.stu.sex == 'female') {
                this.sex_message = "正确";
                this.sexCode = 1;
                this.cSex = "text-success";
            } else {
                this.sex_message = '请输入正确性别..male or female';
                this.cSex = "text-danger";
                this.sexCode = 0;
            }
        },
        detectSexTea: function () {
            if (this.teacher.sex == "male" || this.teacher.sex == 'female' || this.teacher.sex == '') {
                this.sex_message = "正确";
                this.sexCode = 1;
                this.cSex = "text-success";
            } else {
                this.sex_message = '请输入正确性别..male or female';
                this.cSex = "text-danger";
                this.sexCode = 0;
            }
        },
        detectName: function () {
            if ((this.stu.sname != '' && this.show_stu_form == 1) || (this.teacher.name != '' && this.show_tea_form == 1)) {
                this.nameMsg.msg = '';
            }
        },
        detectId: function () {
            if ((this.stu.id != '' && this.show_stu_form == 1) || (this.teacher.id != '' && this.show_tea_form == 1)) {
                this.idMsg.msg = '';
            }
        },
        detectRole: function () {
            if (this.teacher.trole != '') {
                this.trole.msg = '';
            }
        }

    }
})


