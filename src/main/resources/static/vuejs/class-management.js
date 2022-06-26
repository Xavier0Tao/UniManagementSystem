let port = "30";
var class_managementSection = new Vue({
    el:"#class-managementSection",
    data:{
        class_course:{
            classNo:"",
            courses:[],
            tableHead: ['courseNo', "courseName", "courseCredit", "courseHours", "courseForm", "courseTerm", "classNo"],
        }
    },
    methods:{
        queryClassCourse:function (){
            let URL = "http://" + hostName + ":" + port + "/courses";
            let that = this;

            //如果指定了班级编号，则加入路径参数
            if (this.class_course.classNo !== "") URL += "/" + this.class_course.classNo;

            axios.get(URL)
                .then(function (response){
                    if (response.status === 200) {
                        //获取响应中的数据
                        that.class_course.courses = response.data.data;

                    }
                })
        }
    }
})