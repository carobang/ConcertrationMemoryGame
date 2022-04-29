package yy.example.concertrationmemorygame

import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class GameViewModel:ViewModel() {

    public lateinit var buttonFirstClick:ImageButton
    public lateinit var buttonSecondClick:ImageButton

    public var found:Boolean = false
    public var imageIndexEnd:Int = 38
    // public var count:Int = 0
    public var imageButtonMap: HashMap<ImageButton,Int> = hashMapOf()
    public var buttonList: MutableList<ImageButton> = mutableListOf()
   // public var drawableMap:  HashMap<Int,Int> = hashMapOf()
    public var drawableList: MutableList<Int> = mutableListOf()
    public var drawableNameMap: HashMap<Int,Int> = hashMapOf()

    private val count_ = MutableLiveData(0)
    val count: LiveData<Int> = count_

    // lifecycle
    init {
        Log.i("GameViewModel","init")

    }

    fun initGame(){
        buttonList.clear()
        drawableList.clear()
        imageButtonMap.clear()
        drawableNameMap.clear()
        initCount()
    }
    fun isFirstClick():Boolean{
        return count_.value!!.rem(2) == 0
    }
    fun onIncrementCount(){
        //count++
        count_.value = (count_.value?:0) + 1
        Log.i("In view model", count_.value.toString())
    }

    fun initCount(){
        count_.value = 0
    }

    public fun gameEnd():Boolean{
        if(imageButtonMap.isEmpty()){
            return true
        }
        return false
    }

    fun isMatched():Boolean{
        if(imageButtonMap[buttonFirstClick] == imageButtonMap[buttonSecondClick]){
            return true
        }
        return false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "onCleared")
    }
}