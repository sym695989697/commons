/**
 * 时间戳转日期格式
 */
function stamp2datetime(stamp) {
	if (stamp != "" && stamp != null) {
		var d = new Date(parseFloat(stamp));
		return d.getFullYear()
				+ "-"
				+ (((d.getMonth() + 1) >= 10) ? (d.getMonth() + 1) : ("0" + (d.getMonth() + 1)))
				+ "-"
				+ ((d.getDate() >= 10) ? d.getDate() : ("0" + d.getDate()))
				+ " "
				+ ((d.getHours() >= 10) ? d.getHours() : ("0" + d.getHours()))
				+ ":"
				+ ((d.getMinutes() >= 10) ? d.getMinutes() : ("0" + d.getMinutes()))
				+ ":"
				+ ((d.getSeconds() >= 10) ? d.getSeconds() : ("0" + d.getSeconds()));
	}
}

/**
 * 日期转时间戳
 * @param str_time 如"2014-09-01 11:24:32"
 * @returns 如1409541872000
 */
function date2stamp(str_time, flag){
	if(str_time.length<11){
		str_time += " 0:0:0";
	}
	
    var new_str = str_time.replace(/:/g,'-');
    new_str = new_str.replace(/ /g,'-');
    var arr = new_str.split("-");
    var datum = new Date(Date.UTC(arr[0],arr[1]-1,arr[2],arr[3]-8,arr[4],arr[5]));
    var strtotime;
    if(flag == 0){
    	strtotime = datum.getTime();
    }else{
    	strtotime = datum.getTime() + 86399999;
    }
    return strtotime;
}