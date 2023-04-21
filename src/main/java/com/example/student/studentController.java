package com.example.student;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController //tells api
@RequestMapping
public class studentController {
    HashMap<Integer, student> studentdata = new HashMap<>();

    @PostMapping("/addstudent") //addstudent is endpoint after it params are appended
    public String addstudent(@RequestParam int rollno, @RequestParam("name") String name,@RequestParam int age) {
        student stu = new student(rollno, name,age);
        studentdata.put(stu.getRollno(), stu);
        return "Added Successfully";
    }
    @PostMapping("/addstudentobj")
    public String addstudent(@RequestBody student stu) {
        studentdata.put(stu.getRollno(), stu);
        return "added";
    }

    @GetMapping("/getdata") //param variable /getdata? rollno=number
    public student getstudent(@RequestParam("rollno") Integer rollno) {
        //we have to write string in param when we want to give other name
        return studentdata.get(rollno);
    }

    @GetMapping("/getdata/{rollno}") // path variable  so /getdata/numbwer
    public student getstudente(@PathVariable Integer rollno) {
        //we have to write string in param when we want to give other name
        return studentdata.get(rollno);
    }
    @GetMapping("/getalldata")
    public List<student> getAlldata() {
        List<student> li = new ArrayList<>();
        for (student st : studentdata.values()
        ) {
            li.add(st);
        }
        return li;
    }
    @GetMapping("/getdata/{rollno}") // path variable  so /getdata/numbwer
    public List<student> getstudentage(@PathVariable Integer age) {
        //we have to write string in param when we want to give other name
        List<student> li= new ArrayList<>();
        for(student st:studentdata.values()){
            if(st.getAge()>age){
                li.add(st);
            }
        }
        return li;
    }

    @PutMapping("/update")
    public student update(@RequestParam int rollno, @RequestBody student stu) {
        studentdata.put(rollno, stu);
        return studentdata.get(rollno);
    }
    @PutMapping("/update2/{rollno}")
    public student update2(@PathVariable int rollno,@RequestParam(required = false) String name,@RequestParam int age){
        student st= studentdata.get(rollno);
        if(name!=null){
            st.setName(name);
        }
        st.setAge(age);
        return st;
    }
    @DeleteMapping("/remove/{rollno}")
    public String remove(@PathVariable int rollno) {
        studentdata.remove(rollno);
        return "removed";
    }
}