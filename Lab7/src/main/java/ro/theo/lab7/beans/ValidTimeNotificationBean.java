package ro.theo.lab7.beans;

import javax.faces.bean.ManagedBean;
import java.util.Calendar;
import java.util.Date;

@ManagedBean
public class ValidTimeNotificationBean {
    private boolean showWarning;

    public ValidTimeNotificationBean() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour <= 20 && hour >= 8) {
            showWarning = false;
        } else {
            showWarning = true;
        }
    }

    public void setShowWarning(boolean showWarning) {
        this.showWarning = showWarning;
    }

    public boolean isShowWarning() {
        return showWarning;
    }
}
