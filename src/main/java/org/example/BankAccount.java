package org.example;

import java.sql.Time;
import java.util.*;
import java.time.*;

public class BankAccount {
    private int ID;
    private String Name;
    private int Age;
    private String Sex;
    private double Balance;
    private int Count;

    public class Log {
        private String logTime;
        private String logDescription;
        private int sender;
        private int receiver;

        public Log(String logDescription, int sender, int receiver) {
            setLogTime();
            setLogDescription(logDescription);
            setSender(sender);
            setReceiver(receiver);
        }

        public String getLogTime() {
            return logTime;
        }

        public void setLogTime() {
            this.logTime = LocalDate.now() + " " + LocalTime.now();
        }

        public String getLogDescription() {
            return logDescription;
        }

        public void setLogDescription(String logDescription) {
            this.logDescription = logDescription;
        }

        public int getSender() {
            return sender;
        }

        public void setSender(int sender) {
            this.sender = sender;
        }

        public int getReceiver() {
            return receiver;
        }

        public void setReceiver(int receiver) {
            this.receiver = receiver;
        }
    }

    public BankAccount(String name, int age, String sex) {
        setID();
        setName(name);
        setAge(age);
        setSex(sex);
        setBalance();
        setCount();
    }

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = Banking.AccountCount() + 1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        this.Sex = sex;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance() {
        Balance = 0.0;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public int getCount() {
        return Count;
    }

    public void setCount() {
        Count = 0;
    }

//    public Log getLog() {
//        return ;
//    }
}
