package com.example.quiz

object Constents{
    fun getQuestions(): ArrayList<Question>{
        val QuestionsList = ArrayList<Question>()

        val que1 = Question(id = 1,question = "What country does this flag belong to?",
            R.drawable.bd_flag,"India","Brazil","Bangladesh","Peru",3)

        QuestionsList.add(que1)

        val que2 = Question(id = 2,question = "What country does this flag belong to?",
            R.drawable.india_flag,"India","Brazil","Bangladesh","Paru",1)

        QuestionsList.add(que2)


        val que3 = Question(id = 3,question = "What country does this flag belong to?",
            R.drawable.peru_flag,"India","Brazil","Bangladesh","Paru",4)

        QuestionsList.add(que3)


        val que4 = Question(id = 4,question = "What country does this flag belong to?",
            R.drawable.brazil_flag,"India","Brazil","Bangladesh","Paru",2)

        QuestionsList.add(que4)




        return QuestionsList
    }
}
