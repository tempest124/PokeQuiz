package com.example.csaper6.pokequiz;

/**
 * Created by csaper6 on 3/15/17.
 */
public class Question {

    private String question;//TODO: MAKE FULL QUESTION IN MAIN ACTIVIY
    private int[] ans= new int[4];
    private int questionType;
    private int correctAnswer;

    public Question() {
        this.questionType = questionType;
        questionType = (int) ((Math.random() * 3));
        if (questionType == 0)
            question = "Which Pokemon is pokeNumber ";
        else if(questionType == 1)
            question = "Which Pokemon has the weight of ";
        else
            question = "Who's that Pokemon?";

    }

    public int returnType()
    {
        return questionType;
    }

    public String returnQuestion()
    {
        return  question;
    }
}


