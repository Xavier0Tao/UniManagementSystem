//********************测试内容******************************
var item = document.querySelector("#testItem");
var item = new Vue({
    el: "#testItem",
    data: {
        msg: "mess",
        username:""
    },
    methods: {
        test1:function(){
            alert("test...");
        }
    }
});

//******************顶部用户信息***********************
var userInfo = new Vue({
    el:"#userInfo",
    data: {
        user:{
            name:"请登录",
            role:""
        }
    },
    methods: {
        signOut:function (){
            axios.put("http://localhost:30/loginInfo/logout")
                .then(function (response){
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
window.onload=function(){
    //获取用户信息 ，判断用户是否登录
    axios.get("http://localhost:30/loginInfo/role").then(function (response){
            // {code: 1, msg: 'T_普通教师', data: null}
            if(response.data.code == 1){
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
                            userInfo._data.user.name = userInfo._data.user.role == 'STU'? data.sname:data.name;

                        }
                    });
            }
        });

}


var main = new Vue({
    el:"#main",
    data: {
        stuCodes:[],
        teaCodes:[],
        code:{
            showStu:"hide",
            showTea:"hide",
            stuTable:{
                head:['StudentId','CodeColor']
            },
            teaTable:{
                head:['TeacherId','CodeColor']
            }
        }
    },
    methods: {
        getStuCode: function () {
            var that = this;
            axios.get("http://localhost:30/healthCodes/students")
                .then(function (response) {
                    if (response.status == 200 && response.data.code == 1) {
                        console.log(response);
                        that.code.showTea='hide';
                        that.code.showStu='show';
                        that.stuCodes = response.data.data;
                    }
                })
        },
        getTeaCode:function(){
            var that = this;
            axios.get("http://localhost:30/healthCodes/teachers")
                .then(function (response) {
                    if (response.status == 200 && response.data.code == 1) {
                        console.log(response);
                        that.code.showStu='hide';
                        that.code.showTea='show';
                        that.teaCodes = response.data.data;
                    }
                })
        }
    }
})