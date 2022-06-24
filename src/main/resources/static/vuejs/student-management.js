var port = "30";

var studentManagement = new Vue({
    el: "#studentManagement",
    data: {
        stuScore: {
            stuNo: "",
            academicYear: "",
            order: ""
        }
    },
    methods: {
        queryStuScore: function () {
            axios.get("http://" + hostName + ":" + port + "/stuScore?order="+this.stuScore.order
                +"&stuNo="+this.stuScore.stuNo+"&academicYear"+this.stuScore.academicYear)
                .then(function (response) {
                    //data:
                    // code: 1
                    // data: Array(2)
                    // 0: {sno: 1, cno: 5, cterm: 5, academicYear: 3, score: 90, …}
                    // 1: {sno: 4, cno: 9, cterm: 3, academicYear: 2, score: 80, …}
                    // length: 2
                    console.log(response);

                }).catch(function (error) {
                alert("查询失败!");
            });

        }
    }
});