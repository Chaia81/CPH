package repository;

import Models.Arrival;
import Models.Departure;
import Models.Flight;
import Models.Gate;
import util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Repository {



    private Connection conn;

    public Repository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    ArrayList<Arrival> arrivalList = new ArrayList<>();


    public List<Arrival> createArrivalList() {
        ArrayList<Arrival> allArrivals = new ArrayList<>();
        try {
            PreparedStatement readAllArrivals = conn.prepareStatement("SELECT fly_id, dato, arr_and_dep, rute_nr, tid, fly.fly_type, org_des, size FROM fly INNER JOIN koder on fly.fly_type = koder.fly_type WHERE arr_and_dep = ? ");
            readAllArrivals.setString(1, "A");
            ResultSet rs = readAllArrivals.executeQuery();
            while (rs.next()) {
                Arrival tempArrival = new Arrival();
                tempArrival.setFlyId(rs.getInt(1));
                try {
                    Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(rs.getString(2));
                    tempArrival.setDate(date1);
                }
                catch(ParseException parseException){

                }
                tempArrival.setAoD(rs.getString(3));
                tempArrival.setRouteNumber(rs.getString(4));
                tempArrival.setTid(rs.getString(5));
                tempArrival.setFlyType(rs.getString(6));
                tempArrival.setOrigin(rs.getString(7));
                tempArrival.setSize(rs.getString(8));




                arrivalList.add(tempArrival);
            }
            for(Arrival a: arrivalList){
                System.out.println(a);
            }
            System.out.println(arrivalList.size());



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrivalList;

    }

    public List<Arrival> createDepartureList() {
        ArrayList<Departure> departureList = new ArrayList<>();
        try {
            PreparedStatement readAllDepartures = conn.prepareStatement("SELECT fly_id, fly.fly_type, destination_origin, arrOrDep, tid, dato, rute_nummer, size FROM fly INNER JOIN koder on fly.fly_type = koder.fly_type WHERE arrOrDep = ? ");
            readAllDepartures.setString(1, "D");
            ResultSet rs = readAllDepartures.executeQuery();
            while (rs.next()) {
                Departure tempDeparture = new Departure();
                tempDeparture.setFlyId(rs.getInt(1));
                tempDeparture.setFlyType(rs.getString(2));
                tempDeparture.setDestination(rs.getString(3));
                tempDeparture.setAoD(rs.getString(4));
                tempDeparture.setTid(rs.getString(5));
                tempDeparture.setDate(rs.getDate(6));
                tempDeparture.setRouteNumber(rs.getString(7));
                tempDeparture.setSize(rs.getString(8));




                departureList.add(tempDeparture);
            }
            for(Departure d: departureList){
                System.out.println(d);
            }
            System.out.println(departureList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrivalList;

    }


    public List<Gate> createGateList() {
        ArrayList<Gate> gateList = new ArrayList<>();
        try {
            PreparedStatement readAllGates = conn.prepareStatement("SELECT gateId, flyId, personale, size FROM gates ");
            ResultSet rs = readAllGates.executeQuery();
            while (rs.next()) {
                Gate tempGate = new Gate();
                tempGate.setGateId(rs.getInt(1));
                tempGate.setFlyId(rs.getInt(2));
                tempGate.setGatePersonale(rs.getString(3));
                tempGate.setGateSize(rs.getString(4));




                gateList.add(tempGate);
            }
            for(Gate g: gateList){
                System.out.println(g);
            }
            System.out.println(gateList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gateList;

    }





}
