import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public List<Integer> function(List<Time> timesList) {//K
        List<Integer> result = new ArrayList<>();//K

        for (int i = 0; i < timesList.size(); i++) { //F1,F2,F3
            int hr = timesList.get(i).getHours(); //I
            int min = timesList.get(i).getMinutes(); //I
            int sec = timesList.get(i).getSeconds(); //I
            if (hr < 0 || hr > 24){ //H1
                if (hr < 0){ //M1
                    throw new RuntimeException("The hours are smaller than the minimum"); //E1
                }
                else { //M2
                    throw new RuntimeException("The hours are grater than the maximum");//E2
                }
            }
            else if (hr < 24) {//H2
                if (min < 0 || min > 59)//M3
                    throw new RuntimeException("The minutes are not valid!");//E3
                else {//M4
                    if (sec >= 0 && sec <= 59)//N1
                        result.add(hr * 3600 + min * 60 + sec); //E4
                    else //N2
                        throw new RuntimeException("The seconds are not valid");//E5
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) {  //H3
                result.add(hr * 3600 + min * 60 + sec);//E6
            }
            else { //H4
                throw new RuntimeException("The time is greater than the maximum"); //E7
            }
        }
        return result; //R
    }//R
}