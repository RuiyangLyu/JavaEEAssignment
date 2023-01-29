package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaterGate {
    int ID;
    String GateName;
    long BuildTime; // 用时间戳（Timestamp）储存
    //Todo:写一个时间戳转换的方法 stamp2Date

    String Manager;

    //经度： 英文longitude 缩写lng；纬度：英文latitude 缩写lat
    double lng; //经度
    double lat; //纬度

    public WaterGate(int ID, String gateName, String buildTime, String manager, double lng, double lat, String description) {
        this.ID = ID;
        GateName = gateName;
        BuildTime = dateToStamp(buildTime);
        Manager = manager;
        this.lng = lng;
        this.lat = lat;
        Description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGateName() {
        return GateName;
    }

    public void setGateName(String gateName) {
        GateName = gateName;
    }

    public String getBuildTime() { //返回的是日期yyyy-mm-dd格式
        return stamp2Date(BuildTime);
    }

    public void setBuildTime(String Date) { /// TODO: 2023/1/29 convert yyyy-mm-dd to Timestamp
        BuildTime = dateToStamp(Date);
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    String Description;

    /*
     * 时间戳转换为时间
     */
    public String stamp2Date(long BuildTime) {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(BuildTime));
    }

    /*
     * 时间转换为时间戳
     */
    public static long dateToStamp(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        long stamp = 0;
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = sdf.parse(time).getTime();
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        }else {    //时间为空
            stamp = System.currentTimeMillis(); //使用当前日期
        }
        return stamp;
    }
/*
    //调试日期使用
    public static void main(String[] args) {
        WaterGate wg = new WaterGate();
        wg.setBuildTime("2022年2月15日");
        System.out.println(wg.getBuildTime());
    }

 */
}
