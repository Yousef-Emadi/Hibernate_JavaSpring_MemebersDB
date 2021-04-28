package com.joseph.MemberDatabse.archive;

import java.sql.Time;
import java.util.List;

class sandbox{}



class MovingOperation{
    //States

    //Behaviours
}

class Stage{
    //States:
    String stage_name;
    Time start_time;
    Time end_time;
    int performance_rating;

    //Behaviours:

}

class MoverTeam{
    //States
    List<Mover> mover;
    int team_performance_rating;


}

class Mover{

    //State
    String name;
    int rating;
    int teamNumber;

    //Behaviours
    void transit_from_the_office() { }
    void set_stage_start_time(){}
    void set_stage_end_time(){}
    void get_team_performance_rating(){}

}

class Coordinators{
    //States:

    //Behaviours:
    void assign_mover_to_team(){}
    void get_start_start_time(){}
    void get_end_start_time(){}
    void get_team_rating(){}
    void get_mover_rating(){}
}

class Clients {

    //Behaviours:
    void get_stage_name(){}
    void get_team_rating(){}
    void set_stage_team_performance_rating(){}
    void set_mover_rating(){}
}



