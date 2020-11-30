function heatmap() {
    $.ajax({
        type:"post",
        url:"http://localhost:8080/StatisticUserLoc",
        dataType:"json",
        async:false,
        success:function (result) {
            alert("~!!!");
            Console.log(result);
            let jsondata = result;
            alert(result);

            // var map =new AMap.Map("container",{
            //     resizeEnable: true,
            //     center:[116.41,39.92],
            //     zoom:11
            // });
            //
            // if(!isSupportCanvas()){
            //     alert('赶紧换谷歌浏览器，gkd')
            // }
            // var heatMap;
            // map.plugin(["AMap.Heatmap"],function () {
            //     //初始化heatmap对象
            //     heatMap=new AMap.Heatmap(map,{
            //         radius: 25,//给定半径
            //         opacity:[0,0.8]
            //     });
            //     heatMap.setDataSet({
            //         data:heatmapData,
            //         max:1000
            //     });
            // });
            // function isSupportCanvas() {
            //     var element = document.createElement('canvas');
            //     return !!(element.getContext && element.getContext('2d'));
            // }
        },
        error: function(e) {
            alert("sss");
            console.log(e.status);
            console.log(e.responseText);
        }

    })
}

$(document).ready(function () {
    heatmap();
})