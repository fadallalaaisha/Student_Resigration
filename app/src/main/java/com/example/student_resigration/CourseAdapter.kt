package com.example.student_resigration

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.student_resigration.Models.CourseList

class CourseAdapter(var context: Context,var Course_Lists:List<CourseList>):RecyclerView.Adapter<CourseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
      var itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_courses_codehive,parent,false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        var currentCourse=Course_Lists.get(position)
        holder.tvCourse.text=currentCourse.codeName
        holder.tvCourseList.text=currentCourse.courseCode
        holder.tvID.text=currentCourse.courseId.toString()
        holder.tvName.text=currentCourse.codeName

    }

    override fun getItemCount(): Int {
       return Course_Lists.count()
    }
}

class CourseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCourseList=itemView.findViewById<TextView>(R.id.tvCourseList)
    var tvCourse=itemView.findViewById<TextView>(R.id.tvCourse)
    var tvID=itemView.findViewById<TextView>(R.id.tvID)
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
}