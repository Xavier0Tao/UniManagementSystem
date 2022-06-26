var port = "30";

var studentManagement = new Vue({
    el: "#studentManagement",
    data: {
        stuScore: {
            stuNo: "",
            academicYear: "",
            order: "",
            //academicYear: 3
            // cno: 5
            // cterm: 5
            // score: 90
            // sno: 1
            // tid: 2
            tableHead:['学生编号','学期','学年','课程号','分数','教师编号'],
            data:[]
        },
        stuCourse:{
            stuNo: "",
            tableHead: ['stuNo', 'stuName','courseNo','courseName','courseCredit'],
            data:[]
        }
    },
    methods: {
        queryStuScore: function () {
            let that  = this;
            axios.get("http://" + hostName + ":" + port + "/stuScore?order=" + this.stuScore.order
                + "&stuNo=" + this.stuScore.stuNo + "&academicYear=" + this.stuScore.academicYear)
                .then(function (response) {
                    //data:
                    // code: 1
                    // data: Array(2)
                    // 0: {sno: 1, cno: 5, cterm: 5, academicYear: 3, score: 90, …}
                    // 1: {sno: 4, cno: 9, cterm: 3, academicYear: 2, score: 80, …}
                    // length: 2
                    if (response.status === 200 ) {
                        let stuScores = response.data.data;
                        that.stuScore.data = stuScores;
                    }
                }).catch(function (error) {
                alert("查询失败!");
            });
        },
        queryStuCourse: function (response) {
            let that = this;
            let URL;

            //如果用户未输入学生学号，那么查询所有
            if (this.stuCourse.stuNo.length < 1 || this.stuCourse.stuNo === "") {
                URL = "http://" + hostName + ":" + port + "/stuScore/stuCourse";
            } else {
                //如果用户指定了查询的学号，则通过请求参数传给接口
                URL = "http://" + hostName + ":" + port + "/stuScore/stuCourse" + "?stuNo=" + this.stuCourse.stuNo
            }

            //请求学生所学课程和学分信息
            axios.get(URL)
                .then(function (response) {
                    if (response.status === 200) {
                        console.log(response);
                        //data:
                        // code: 1
                        // data: Array(2)
                        // 0: {stuNo: 1, stuName: 'VB', courseNo: 5, courseName: 'JavaEE', courseCredit: 4}
                        // 1: {stuNo: 4, stuName: 'stu4', courseNo: 9, courseName: '美学原理', courseCredit: 3}
                        // length: 2
                        // [[Prototype]]: Array(0)
                        // msg: "成功"
                        let stuCourses = response.data.data;
                        that.stuCourse.data = stuCourses;
                    }
                }).catch(function (error) {
                alert("查询失败!");
            });
        }
    }
});