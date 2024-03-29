//********************测试内容******************************
var item = document.querySelector("#testItem");
var item = new Vue({
    el: "#testItem",
    data: {
        username: ""
    },
    methods: {
        test1: function () {
            alert("test...");
        }
    }
});


let hostName ='localhost';

//******************顶部用户信息***********************
var userInfo = new Vue({
    el: "#userInfo",
    data: {
        user: {
            name: "Plz Login",
            role: "",
            codeColor: "",
            stuffId: ""
        }
    },
    methods: {
        signOut: function () {
            axios.put("http://"+hostName+":30/loginInfo/logout")
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
    axios.get("http://"+hostName+":30/loginInfo/role").then(function (response) {
        // {code: 1, msg: 'T_普通教师', data: null}
        if (response.data.code == 1) {
            userInfo._data.user.role = response.data.msg;
            axios.get("http://"+hostName+":30/loginInfo/roleInfo")
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
                        var data = response.data.data
                        // if (userInfo._data.user.role == 'STU')
                        userInfo._data.user.stuffId = userInfo._data.user.role == 'STU' ? data.sno : data.teacherId;
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
        covid_Check: {
            condition: {
                "beenAboard": "",
                "beenArea": "",
                "close": "",
                "confirmed": "",
                "seriousUnheathy": "",
                "unhealthy": ""
            },
            identity: "",
            msg: {
                content: "",
                color: ""
            },
            healthy: ""
        }
    },
    methods: {
        getStuCode: function () {
            var that = this;
            axios.get("http://"+hostName+":30/healthCodes/students")
                .then(function (response) {
                    if (response.status == 200 && response.data.code == 1) {
                        console.log(response);
                        that.code.showTea = 'hide';
                        that.code.showStu = 'show';
                        that.stuCodes = response.data.data;
                        window.location.href = "http://"+hostName+":30/index.html#studentCodes";
                    }
                })
        },
        getTeaCode: function () {
            var that = this;
            axios.get("http://"+hostName+":30/healthCodes/teachers")
                .then(function (response) {
                    if (response.status == 200 && response.data.code == 1) {
                        console.log(response);
                        that.code.showStu = 'hide';
                        that.code.showTea = 'show';
                        that.teaCodes = response.data.data;
                        window.location.href = "http://"+hostName+":30/index.html#teacherCodes";
                    }
                })
        },
        hideCodes: function () {
            this.code.showStu = 'hide';
            this.code.showTea = 'hide';
        },
        submitCovidCheck: function () {
            //*****************战疫打卡表单校验***************
            var flag = true;

            console.log("this.covid_Check.identity..." + this.covid_Check.identity);

            if (this.covid_Check.identity == '') {
                flag = false;
            }

            if (userInfo._data.user.role == '') {
                flag = false
                alert("请先登录");
            }

            var condition = this.covid_Check.condition;

            console.log(condition);

            //如果有未填选项 返回false
            if (condition.beenAboard == '' || condition.beenArea == ''
                || condition.close == '' || condition.confirmed == ''
                || this.covid_Check.healthy == '') {
                flag = false;
            }

            //flag == false 表单校验不通过
            if (flag == false) {
                this.covid_Check.msg.content = '请选择全部信息';
                this.covid_Check.msg.color = "text-danger";
                return flag;
            } else {
                //根据有几项不适症状判断 健康情况
                if (this.covid_Check.healthy > 0) {
                    if (this.covid_Check.healthy > 1) {
                        condition.seriousUnheathy = 1;
                        condition.unhealthy = 0;
                    } else {
                        condition.unhealthy = 1;
                        condition.seriousUnheathy = 0;
                    }
                }

                var that = this;

                //否则 flag == true 表单校验通过
                axios.post("http://"+hostName+":30/healthCodes/submit/" + this.covid_Check.identity,
                    this.covid_Check.condition)
                    .then(function (response) {
                        //status === 200 ajax请求响应接收成功
                        if (response.status == 200) {
                            console.log(response);
                            /**********这里要用 that  因为axios中的this 不是vue对象中的**********/
                            that.covid_Check.msg.content = '打卡信息递交成功,您的健康码信息为' + response.data.data;

                            /**
                             * 根据健康码不同的颜色渲染提示信息  */
                            switch (response.data.data) {
                                case 'GREEN': {
                                    that.covid_Check.msg.color = "text-success";
                                    break;
                                }
                                case 'RED': {
                                    that.covid_Check.msg.color = "text-danger";
                                    break;
                                }
                                case 'YELLOW': {
                                    that.covid_Check.msg.color = "text-warning";
                                    break;
                                }
                            }

                        }
                    }).catch(function (error) {
                    console.log(error.data);
                });

                /**
                 * 提交请求后，清空该属性，防止影响下一次打卡
                 */
                condition.unhealthy = 0;
                condition.seriousUnheathy = 0;
            }

        }

    }
})