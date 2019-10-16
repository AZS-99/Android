package com.example.adam_assignment_2;

    public class QuizBook {
        public static String[] questions = {
                "Canberra is the capital of Australia.",
                "The Pacific ocean is larger than the Atlantic",
                "The Suez Canal connects the Red Sea and the Indian Ocean",
                "The source of the Nile River is Egypt",
                "The Amazon is the longest river in the Americas",
                "Lake Baikal is the oldest and deepest fresh water lake"
        };

        public static Boolean[] answers = {
                true, true, false, false, true, true
        };

        public static Boolean[] hintUsed = {
                false, false, false, false, false, false
        };

        public static Boolean[] cheated = {
                false, false, false, false, false, false
        };

        public static String[] hints = {
                "Sydney is not the capital of Australia",
                "There are fewer fish in the Atlantic",
                "The Suez Canal connects two seas",
                "Omar Sharief should know the answer",
                "You can buy many books on the Amazon website",
                "Lake Baikal is located in Russia"
        };
    }