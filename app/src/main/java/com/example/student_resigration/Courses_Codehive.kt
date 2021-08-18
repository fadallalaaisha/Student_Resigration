package com.example.student_resigration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.student_resigration.Models.CourseList

class Courses_Codehive : AppCompatActivity() {
    lateinit var rvCourses:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_codehive)
        DisplayCourses()
    }
    fun DisplayCourses(){
        var courseList= listOf(
            CourseList("Kotlin","220",2,"Aisha"),
        CourseList("Python","001",3,"John"),
        CourseList("Javascript","225",4,"Tabby"),
        CourseList("Design","001",6,"Tutu"),
            CourseList("UI","003",9,"Rouda")
        )
        rvCourses=findViewById(R.id.rvCourses)
     var courseAdapter=CourseAdapter(baseContext,courseList)
        rvCourses.apply {
            layoutManager=LinearLayoutManager(baseContext)
            rvCourses.adapter=courseAdapter
        }
        }
    }

