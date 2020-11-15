function Mark(imsi) {
    //jquery封装的ajax请求后端
    $.ajax({
        type: "post",
        data: "imsi=" + imsi,
        url: "QueryUserPath.do",
        dataType: "json",   //设置返回的数据类型为json
        success: function(result) {
            //后端查询数据时按照时间从小到大排序
            let jsondata = result["path"];

            //调用高德API
            var map = new AMap.Map('container', {
                zoom: 15, //级别
                center: [jsondata[0].longitude, jsondata[0].latitude]
            });

            // 右击可以获取鼠标所在的经纬度
            var clickHandler = function(e) {
                alert('您在[ ' + e.lnglat.getLng() + ',' + e.lnglat.getLat() + ' ]的位置点击了地图！');
            };

            // 绑定事件
            map.on('rightclick', clickHandler);

            // MarkerTime类似于HashMap，key值为经纬度，value为该基站捕获到信号的时间。用于把基站和经过基站的时间对应起来
            // 具体为key 经度-维度 例如key为123.426355-41.807557，value为"00:04:51  00:07:15  00:41:22  00:43:19  00:48:59"
            let MarkerTime = {};
            // MarkerList为按照时间排序的点，用于绘制路径。
            let MarkerList = [];

            for (let index in jsondata) {
                MarkerList[index] = [jsondata[index].longitude, jsondata[index].latitude];
                if (typeof(MarkerTime[String(jsondata[index].longitude) + "-" + String(jsondata[index].latitude)]) == "undefined")
                    MarkerTime[String(jsondata[index].longitude) + "-" + String(jsondata[index].latitude)] = "";
                MarkerTime[String(jsondata[index].longitude) + "-" + String(jsondata[index].latitude)] += jsondata[index].time.substring(11, 19) + '  ';
            }

            // 在地图上标注点，旁边写获得信号的时间
            for (let key in MarkerTime) {
                let tmp = key.split('-');
                map.add(new AMap.Marker({
                    position: [tmp[0], tmp[1]],
                    content: '<div><div class="icon"></div><div class = "TimeBlock">' + MarkerTime[key] + '</div></div>'
                }))
            }

            // 按照时间顺序，将各个点连接起来
            let polyline = new AMap.Polyline({
                path: MarkerList,
                showDir: true
            });

            map.add(polyline);
        },
        error: function(e) {
            console.log(e.status);
            console.log(e.responseText);
        }
    })

}

$(document).ready(function() {
    //初始化页面的时候加载imsi=460000095007329090用户的数据
    Mark('460000095007329090');
    //用户选择框更改数据时，ajax请求后台，请求新的数据，异步刷新页面
    $("#imsi").change(
        function() {
            Mark($("#imsi").val());
        }
    );

    //用户选择框获得焦点（例如鼠标点击选择框）时清空选择框内的数据
    $("#imsi").focus(function() {
        $("#imsi").val("");
    })

    //是否显示时间戳
    $("#ControlTimeBlock").click(function() {
        if ($(".TimeBlock").css("display") == "none") $(".TimeBlock").css("display", "block");
        else $(".TimeBlock").css("display", "none");
    })
})