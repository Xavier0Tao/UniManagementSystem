
var registerCard = new Vue({
    el:"#login-card",
    data:{
        show_stu_form:0,
        show_tea_form:0,
        identity:{
            msg:"",
            code:1
        },
        ids:{
          msg:"",
          code:1
        },
        stu: {
            identity:"",
            stuId:""
        },
        teacher:{
            identity: "",
            teaId:""
        }
    },
    methods:{
        click_role_tea:function(){
            this.show_stu_form=0;
            this.show_tea_form=1;
        },
        click_role_stu:function(){
            this.show_tea_form=0;
            this.show_stu_form=1;
        },
        formCheck: function (obj) {
            // window.location.href="http://121.5.43.28/";
            var flag = true;
            if (this.show_stu_form == 1) {
                if (this.stu.stuId == '') {
                    flag = false;
                    this.ids.code= 0;
                }
                if(this.stu.identity.length === 0) {
                    flag=false;
                    this.identity.code=0;
                }
            }else{
                if(this.teacher.teaId == '') {
                    flag = false;
                    this.ids.code = 0;
                }
                if(this.teacher.identity == '') {
                    flag = false;
                    this.identity.code = 0;
                }
            }
            if (flag == false) return flag;

            //至此...表单校验结束 表单已经达到可提交阶段
            if (this.show_stu_form == 1) {
                var params = new URLSearchParams();
                params.append("identity", this.stu.identity);
                params.append("studentNo", this.stu.stuId);
                axios.post("http://localhost:30/students/login",params)
                    .then(function (response){
                        if(response.status == 200) {
                            if (response.data.code == 1){
                                window.location.href = "/index.html";
                            }
                        }
                    }).catch(function (error){
                        alert("登录失败,请重新登录");
                });
            }else {
                var params = new URLSearchParams();
                params.append("identity", this.teacher.identity);
                params.append("teacherId", this.teacher.teaId);
                axios.post("http://localhost:30/teachers/login",params)
                    .then(function (response){
                        if(response.status == 200) {
                            if (response.data.code == 1){
                                window.location.href = "/index.html";
                            }
                        }
                    }).catch(function (error){
                    alert("登录失败,请重新登录");
                })
            }
        },
        detectIdentity:function (){
            this.identity.code = 1;
        },
        detectId:function (){
            this.ids.code=1;
        }
    }
})

