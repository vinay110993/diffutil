package com.example.diffutilexample

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment(){

    abstract fun provideScreenTitle(): String
}