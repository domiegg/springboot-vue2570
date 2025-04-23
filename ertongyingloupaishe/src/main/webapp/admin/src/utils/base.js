const base = {
    get() {
        return {
            url : "http://localhost:8080/ertongyingloupaishe/",
            name: "ertongyingloupaishe",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ertongyingloupaishe/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "儿童影楼拍摄管理系统"
        } 
    }
}
export default base
