package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var score = 0
    private var currentWordCount = 0
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    lateinit var _currentScrambledWord: String

    init{
        getNextWord()
    }

    val currentScrambledWord: String
        get() = _currentScrambledWord


    fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, ignoreCase = false)) {
            tempWord.shuffle()
        }

        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            currentWordCount++
            wordsList.add(currentWord)
        }

    }


}