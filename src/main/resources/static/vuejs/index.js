//********************测试内容******************************
var item = document.querySelector("#testItem");
var item = new Vue({
    el: "#testItem",
    data: {
        msg: "mess",
        username: ""
    },
    methods: {
        test1: function () {
            alert("test...");
        }
    }
});

//******************顶部用户信息***********************
var userInfo = new Vue({
    el: "#userInfo",
    data: {
        user: {
            name: "请登录",
            role: ""
        }
    },
    methods: {
        signOut: function () {
            axios.put("http://localhost:30/loginInfo/logout")
                .then(function (response) {
                    if (response.data.code == 1) {
                        alert("登出成功！");
                    }
                    window.location.href = "/index.html";
                })
        }
    }
});


// *****************窗口加载时的初始化内容******************
// 如一些用户信息
window.onload = function () {
    //获取用户信息 ，判断用户是否登录
    axios.get("http://localhost:30/loginInfo/role").then(function (response) {
        // {code: 1, msg: 'T_普通教师', data: null}
        if (response.data.code == 1) {
            userInfo._data.user.role = response.data.msg;
            axios.get("http://localhost:30/loginInfo/roleInfo")
                .then(function (response) {
                    // {code: 0, msg: '没有登录', data: null}
                    /**
                     * data:
                         * code: 1
                         * data:
                             * classno: 22
                             * collid: 6
                             * id: "33021220011104"
                             * mno: 8
                             * sage: null
                             * scredits: 0
                             * sex: null
                             * sname: "stu3"
                             * sno: 3
                             * sori: "宁波"
                             * [[Prototype]]: Object
                             * msg: "成功"
                             */
                    console.log(response);

                    if (response.status == 200 && response.data.code == 1) {
                        /* 获得vue对象中的data */
                        var data = response.data.data;
                        userInfo._data.user.name = userInfo._data.user.role == 'STU' ? data.sname : data.name;

                    }
                });
        }
    });

}

//*************主页主体内容****************
var main = new Vue({
    el: "#main",
    data: {
        stuCodes: [],
        teaCodes: [],
        code: {
            showStu: "hide",
            showTea: "hide",
            stuTable: {
                head: ['StudentId', 'CodeColor']
            },
            teaTable: {
                head: ['TeacherId', 'CodeColor']
            },
        },
        covid_Check:{
            condition:{
                "beenAboard": "",
                "beenArea": "",
                "close": "",
                "confirmed": "",
                "seriousUnheathy": "",
                "unhealthy": ""
            },
            identity:"",
            msg:{
                content:"",
                color:""
            },
            healthy:""
        }
    },
    methods: {
        getStuCode: function () {
            var that = this;
            axios.get("http://localhost:30/healthCodes/students")
                .then(function (response) {
                    if (response.status == 200 && response.data.code == 1) {
                        console.log(response);
                        that.code.showTea = 'hide';
                        that.code.showStu = 'show';
                        that.stuCodes = response.data.data;
                        window.location.href = "http://localhost:30/index.html#studentCodes";
                    }
                })
        },
        getTeaCode: function () {
            var that = this;
            axios.get("http://localhost:30/healthCodes/teachers")
                .then(function (response) {
                    if (response.status == 200 && response.data.code == 1) {
                        console.log(response);
                        that.code.showStu = 'hide';
                        that.code.showTea = 'show';
                        that.teaCodes = response.data.data;
                        window.location.href = "http://localhost:30/index.html#teacherCodes";
                    }
                })
        },
        hideCodes:function (){
            this.code.showStu='hide';
            this.code.showTea='hide';
        },
        submitCovidCheck: function () {
            var flag = true;

            console.log("this.covid_Check.identity..." + this.covid_Check.identity);

            if (this.covid_Check.identity == '') {
                flag = false;
            }

            var condition = this.covid_Check.condition;
            console.log(condition);
            console.log(condition.beenAboard);
            console.log(this.covid_Check.healthy);
            if (condition.beenAboard == '' || condition.beenArea == ''
                || condition.close == '' || condition.confirmed ==''
                || this.covid_Check.healthy =='') {
                flag = false;
            }

            //flag == false 表单校验不通过
            if (flag == false) {
                this.covid_Check.msg.content = '请选择全部信息';
                this.covid_Check.msg.color = "text-danger";
                return flag;
            }else {
                //根据有几项不适症状判断 健康情况
                if (this.covid_Check.healthy > 0) {
                    if (this.covid_Check.healthy > 1) {
                        condition.seriousUnheathy = 1;
                        condition.unhealthy = 0;
                    }else {
                        condition.unhealthy = 1;
                        condition.seriousUnheathy = 0;
                    }
                }

                //否则 flag == true 表单校验通过
                axios.post("http://localhost:30/healthCodes/submit/"+this.covid_Check.identity, {
                    condition: this.covid_Check.condition
                })
                    .then(function (response) {
                        //status === 200 ajax请求响应接收成功
                        if (response.status == 200) {
                            console.log(response);
                            this.covid_Check.msg.content = '打卡信息递交成功,您的健康码信息为'+response.data.data;
                            this.covid_Check.msg.color = "text-success";
                        }
                    }).catch(function (error) {
                    console.log(error.data);
                });
            }

        }

    }
})