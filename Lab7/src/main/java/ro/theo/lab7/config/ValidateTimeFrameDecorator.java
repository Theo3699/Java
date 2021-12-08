package ro.theo.lab7.config;

import ro.theo.lab7.beans.UserBean;
import ro.theo.lab7.repositories.RepositoryInterface;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

@Decorator
public abstract class ValidateTimeFrameDecorator implements RepositoryInterface {
    @Inject
    @Delegate
    @Any
    RepositoryInterface anInterface;

    public abstract int countAdmins();

    @Override
    public void save(UserBean user) {
        Calendar cal = Calendar.getInstance(); //Create Calendar-Object
        cal.setTime(new Date());               //Set the Calendar to now
        int hour = cal.get(Calendar.HOUR_OF_DAY); //Get the hour from the calendar
        if (hour <= 23 && hour >= 8)              // Check if hour is between 8 am and 11pm
        {
            System.out.println("Correct time frame");
        }
    }
}

