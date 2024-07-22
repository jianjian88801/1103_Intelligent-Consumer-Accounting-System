const base = {
    get() {
        return {
            url : "http://localhost:8080/zhinnegxiaofeijizhang/",
            name: "zhinnegxiaofeijizhang",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhinnegxiaofeijizhang/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "大学生智能消费记账系统"
        } 
    }
}
export default base
