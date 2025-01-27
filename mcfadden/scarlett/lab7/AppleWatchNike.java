package mcfadden.scarlett.lab7;

// คลาส AppleWatchNike สืบทอดมาจากคลาส AppleWatch 
// และติดตั้งอินเทอร์เฟซ RunnerStatsCollector และ HealthMonitorer
public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
    // ตัวแปร totalDistance ใช้เก็บระยะทางรวมที่วิ่งได้ (หน่วยเป็นกิโลเมตร)
    private double totalDistance;
    // ตัวแปร avgHeartRate ใช้เก็บอัตราการเต้นของหัวใจเฉลี่ย (หน่วยเป็น bpm)
    private double avgHeartRate;
    // ตัวแปร avgSleepHours ใช้เก็บจำนวนชั่วโมงการนอนเฉลี่ย
    private double avgSleepHours;

    // Constructor สำหรับสร้าง AppleWatchNike โดยไม่ระบุข้อมูลสุขภาพเพิ่มเติม
    public AppleWatchNike(String color, double price, String modelName) {
        // เรียกใช้ Constructor ของคลาสแม่ (AppleWatch)
        super(color, price, modelName);
    }

    // Constructor สำหรับสร้าง AppleWatchNike โดยระบุข้อมูลสุขภาพเพิ่มเติม
    public AppleWatchNike(String color, double price, String modelName,
                          double totalDistance, double avgHeartRate, double avgSleepHours) {
        // เรียกใช้ Constructor ของคลาสแม่ (AppleWatch)
        super(color, price, modelName);
        // กำหนดค่าให้กับตัวแปรที่เกี่ยวข้องกับข้อมูลสุขภาพ
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }

    // Override เมธอดจากอินเทอร์เฟซ RunnerStatsCollector 
    // แสดงข้อมูลระยะทางทั้งหมดที่วิ่งได้
    @Override
    public void displayRunningStats() {
        System.out.println("Total Distance: " + totalDistance + " km");
    }

    // Override เมธอดจากอินเทอร์เฟซ HealthMonitorer 
    // แสดงข้อมูลอัตราการเต้นของหัวใจเฉลี่ย
    @Override
    public void displayHeartRates() {
        System.out.println("Average Heart Rate: " + avgHeartRate + " bpm");
    }

    // Override เมธอดจากอินเทอร์เฟซ HealthMonitorer 
    // แสดงข้อมูลจำนวนชั่วโมงการนอนเฉลี่ย
    @Override
    public void displaySleepHours() {
        System.out.println("Average Sleep Hours: " + avgSleepHours + " hours");
    }

    // Override เมธอด toString 
    // ใช้สำหรับแปลงข้อมูลของ AppleWatchNike เป็นข้อความ
    @Override
    public String toString() {
        return "AppleWatchNike(color: " + getColor() + " price: " + getPrice() + " model name: " + getModelName() + " GPS distance: " + totalDistance + " km)";
    }
}
