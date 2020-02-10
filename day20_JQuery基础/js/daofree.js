//document.getElementById 长记，麻烦
// 封装方法，根据id获取元素对象,简化书写
function get(id) {
    let obj = document.getElementById(id);
    return obj;
}


function $(id) {
    let obj = document.getElementById(id);
    return obj;
}
