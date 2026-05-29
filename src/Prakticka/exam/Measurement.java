package exam;

/**
 * Trida pro jedno mereni u pacienta
 */
public class Measurement {
    String patientId;
    /** Kolik minut u nas pacient je v dobe mereni */
    int minute;
    /** Okysliceni - procentualni hodnota */
    double oxygen;
    /** Srdecni tep */
    int bpm;
    int systolic; // ...krevni tlak...
    int diastolic;//...ten, ktery ma byt nizsi

    public Measurement(String patientId, int minute, double oxygen, int bpm, int systolic, int diastolic) {
        this.patientId = patientId;
        this.minute = minute;
        this.oxygen = oxygen;
        this.bpm = bpm;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "patientId='" + patientId + '\'' +
                ", minute=" + minute +
                ", oxygen=" + oxygen +
                ", bpm=" + bpm +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                '}';
    }
}





