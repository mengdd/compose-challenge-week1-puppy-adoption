package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

object Repository {

    fun getPuppies(): List<Puppy> {
        return listOf(
            Puppy(
                0,
                "Sparky",
                "Golden Retriever",
                "Female",
                "8 months old",
                "2.5 kms away",
                R.drawable.dog1
            ),
            Puppy(
                1,
                "Charlie",
                "Boston Terrier",
                "Male",
                "1.5 years old",
                "2.6 kms away",
                R.drawable.dog2
            ),
            Puppy(
                2,
                "Max",
                "Siberian Husky",
                "Male",
                "1 year old",
                "2.9 kms away",
                R.drawable.dog3
            ),
            Puppy(
                3,
                "Daisy",
                "Maltese",
                "Female",
                "7 months old",
                "3.1 kms away",
                R.drawable.dog4
            ),
            Puppy(
                4,
                "Zeo",
                "Jack Russell Terrier",
                "Male",
                "8 months old",
                "4.5 kms away",
                R.drawable.dog5
            ),
        )
    }
}