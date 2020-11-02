package com.example.diffutilexample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiffUtilViewModel : ViewModel() {

    private val listLiveData = MutableLiveData<List<CustomModel>>()
    fun listLiveDataObserver(): LiveData<List<CustomModel>> = listLiveData

    private val msg = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    private val imageList = listOf<String>(
        "https://images.unsplash.com/photo-1494548162494-384bba4ab999?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80",
        "https://static.toiimg.com/photo/72975551.cms",
        "https://images.unsplash.com/photo-1503803548695-c2a7b4a5b875?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max",
        "https://photojournal.jpl.nasa.gov/jpeg/PIA23689.jpg",
        "https://p.bigstockphoto.com/GeFvQkBbSLaMdpKXF1Zv_bigstock-Aerial-View-Of-Blue-Lakes-And--227291596.jpg",
        "https://photojournal.jpl.nasa.gov/jpeg/PIA23689.jpg",
        "https://media.gettyimages.com/photos/marina-beach-salmiya-picture-id949496572?s=612x612",
        "https://www.w3schools.com/howto/img_snow.jpg",
        "https://m.hindustantimes.com/rf/image_size_444x250/HT/p2/2020/05/21/Pictures/_037138a2-9b47-11ea-a010-c71373fc244b.jpg",
        "https://images.all-free-download.com/images/graphicthumb/hd_picture_of_the_beautiful_natural_scenery_03_166249.jpg"
    )

    private val titleList = listOf<String>("Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10")

    fun getList(){
        val list = mutableListOf<CustomModel>()
        list.add(CustomModel(url = imageList[0], id = 0, title = titleList[0], msg = msg))
        list.add(CustomModel(url = imageList[1], id = 1, title = titleList[1], msg = msg))
        list.add(CustomModel(url = imageList[2], id = 2, title = titleList[2], msg = msg))
        list.add(CustomModel(url = imageList[3], id = 3, title = titleList[3], msg = msg))
        list.add(CustomModel(url = imageList[4], id = 4, title = titleList[4], msg = msg))
        list.add(CustomModel(url = imageList[5], id = 5, title = titleList[5], msg = msg))
        list.add(CustomModel(url = imageList[6], id = 6, title = titleList[6], msg = msg))
        list.add(CustomModel(url = imageList[7], id = 7, title = titleList[7], msg = msg))
        list.add(CustomModel(url = imageList[8], id = 8, title = titleList[8], msg = msg))
        list.add(CustomModel(url = imageList[9], id = 9, title = titleList[9], msg = msg))
        list.add(CustomModel(url = imageList[0], id = 10, title = titleList[0], msg = msg))
        list.add(CustomModel(url = imageList[1], id = 11, title = titleList[1], msg = msg))
        list.add(CustomModel(url = imageList[2], id = 12, title = titleList[2], msg = msg))
        list.add(CustomModel(url = imageList[3], id = 13, title = titleList[3], msg = msg))
        list.add(CustomModel(url = imageList[4], id = 14, title = titleList[4], msg = msg))
        list.add(CustomModel(url = imageList[5], id = 15, title = titleList[5], msg = msg))
        list.add(CustomModel(url = imageList[6], id = 16, title = titleList[6], msg = msg))
        list.add(CustomModel(url = imageList[7], id = 17, title = titleList[7], msg = msg))
        list.add(CustomModel(url = imageList[8], id = 18, title = titleList[8], msg = msg))
        list.add(CustomModel(url = imageList[9], id = 19, title = titleList[9], msg = msg))

        listLiveData.postValue(list)
    }

    fun addItem(){
        val list = listLiveData.value?.toMutableList() ?: mutableListOf()
        list.add(2, CustomModel(url = imageList[8], id = list.size, title = titleList[8], msg = msg))
        listLiveData.postValue(list)
    }

}
