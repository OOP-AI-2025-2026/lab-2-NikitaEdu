package ua.opnu;


public class TimeSpan {

    int hours;
    int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            System.out.println("Неправильний формат часу: години >= 0, хвилини від 0 до 59.");
        }else{
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            System.out.println("Неправильний формат часу: години >= 0, хвилини від 0 до 59.");
        }else{
            this.hours += hours;
            this.minutes += minutes;
            normalizeTime();
        }

    }

    public void addTimeSpan(TimeSpan timeSpan) {
        this.hours += timeSpan.getHours();
        this.minutes += timeSpan.getMinutes();
        normalizeTime();
    }

    private void normalizeTime() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    double getTotalHours() {
        return this.hours + (double) minutes / 60;
    }

    int getTotalMinutes() {
        return hours * 60 + this.minutes;
    }

    void subtract(TimeSpan span) {
        int totalMinutesThis = this.hours * 60 + this.minutes;
        int totalMinutesOther = span.getHours() * 60 + span.getMinutes();

        if (totalMinutesOther > totalMinutesThis) {
            System.out.println("Вхідний інтервал більший за поточний, інтервал не змінюється.");
            return;
        }

        int remainingMinutes = totalMinutesThis - totalMinutesOther;
        this.hours = remainingMinutes / 60;
        this.minutes = remainingMinutes % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            System.out.println("Фактор повинен бути більше нуля.");
        } else{
            int totalMinutes = (this.hours * 60 + this.minutes) * factor;
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }
}