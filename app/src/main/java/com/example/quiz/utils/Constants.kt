package com.example.quiz.utils

import com.example.quiz.model.Questions

object Constants{
    fun getQuestions(): MutableList<Questions>{
        val questionList = mutableListOf<Questions>()
        val que1 = Questions(1,"What is 2+2 ?","2","3","4","5",4)
        questionList.add(que1)
        val que2 = Questions(2,"What is 3+3 ?","5","3","6","8",3)
        questionList.add(que2)
        val que3 = Questions(3,"What is 4+4 ?","8","7","6","5",1)
        questionList.add(que3)
        val que4 = Questions(4,"What is 5+5 ?","10","11","12","13",1)
        questionList.add(que4)
        val que5 = Questions(5,"What is 6-4 ?","2","1","3","7",1)
        questionList.add(que5)


        return questionList
    }
}