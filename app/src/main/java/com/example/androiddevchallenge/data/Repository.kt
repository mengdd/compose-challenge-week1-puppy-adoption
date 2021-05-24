/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
