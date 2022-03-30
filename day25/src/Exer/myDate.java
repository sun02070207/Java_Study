package Exer;/*
@author Serenity
@create 2022-02-15-14:45
*/

public class myDate {
    private int year;
    private int month;
    private int day;

    public myDate(){}

    public myDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

//    @Override
//    方式二
    public int compareTo(Object o){
        if (o instanceof myDate){
            myDate m = (myDate) o;
            int yearnum = this.getYear() - m.getYear();
            if (yearnum != 0){
                return yearnum;
            }
            int monthnum = this.getMonth() - m.getMonth();
            if (monthnum != 0){
                return monthnum;
            }
            int daynum = this.getDay() - m.getDay();
            return daynum;
        }
        throw new RuntimeException("参数类型错误。");
    }
}
