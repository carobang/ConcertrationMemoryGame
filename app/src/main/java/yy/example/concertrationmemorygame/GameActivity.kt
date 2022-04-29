package yy.example.concertrationmemorygame

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.Identifier
import yy.example.concertrationmemorygame.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    // binding with gameviewmodel
    private lateinit var gameViewModel: GameViewModel

    // cout text view
    private lateinit var countScoreTextView:TextView
    // match notification text view
    private lateinit var matchNotification:TextView
    // binding
    private lateinit var binding:ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // not using the old setContentView, need to use the binding version
        // setContentView(R.layout.activity_game)

        // binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_game)
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.viewModel = gameViewModel
        binding.executePendingBindings()
        binding.lifecycleOwner = this

        // get text view
        countScoreTextView= findViewById(R.id.GameTextViewCountScore)
        matchNotification = findViewById(R.id.GameTextViewNotification)

        // set up the game
        setUpGame()
    }

    // set the imageview back to the card background
    private fun setImageBack(button:ImageButton){
       button.setImageResource(R.drawable.card_back)
    }

    // initial gameViewModel's button by random choose from the button list and choose from image list
    private fun initialMap(){
        // get random image
        var identifier = gameViewModel.drawableList.random()
        // remove the image from the list
        gameViewModel.drawableList.remove(identifier)
        // get random pair buttons and bind with chosen image
        gameViewModel.imageButtonMap[pickRandomFromBtnList()] = identifier
        gameViewModel.imageButtonMap[pickRandomFromBtnList()] = identifier

    }

    // initial gameViewModel's drawableNameMap: [Key:image,value:string]
    private fun initdrawableNameMap(){
        gameViewModel.drawableNameMap[R.drawable.card_00] = R.string.Rhino
        gameViewModel.drawableNameMap[R.drawable.card_01] = R.string.fox
        gameViewModel.drawableNameMap[R.drawable.card_02] = R.string.raccoon
        gameViewModel.drawableNameMap[R.drawable.card_03] = R.string.bear
        gameViewModel.drawableNameMap[R.drawable.card_04] = R.string.kangaroo
        gameViewModel.drawableNameMap[R.drawable.card_05] = R.string.leopard
        gameViewModel.drawableNameMap[R.drawable.card_06] = R.string.snake
        gameViewModel.drawableNameMap[R.drawable.card_07] = R.string.elephant
        gameViewModel.drawableNameMap[R.drawable.card_08] = R.string.hippo
        gameViewModel.drawableNameMap[R.drawable.card_09] = R.string.moose
        gameViewModel.drawableNameMap[R.drawable.card_10] = R.string.crocodile
        gameViewModel.drawableNameMap[R.drawable.card_11] = R.string.wolf
        gameViewModel.drawableNameMap[R.drawable.card_12] = R.string.bear

   }

    // random choose button from list
    private fun pickRandomFromBtnList(): ImageButton {
        var pick = gameViewModel.buttonList.random()
        gameViewModel.buttonList.remove(pick)
        return pick
    }

    // initial gameViewModel's drawableList from random pick
    private fun initDrawableList(){
        gameViewModel.drawableList.add(R.drawable.card_00)
        gameViewModel.drawableList.add(R.drawable.card_01)
        gameViewModel.drawableList.add(R.drawable.card_02)
        gameViewModel.drawableList.add(R.drawable.card_03)
        gameViewModel.drawableList.add(R.drawable.card_04)
        gameViewModel.drawableList.add(R.drawable.card_05)
        gameViewModel.drawableList.add(R.drawable.card_06)
        gameViewModel.drawableList.add(R.drawable.card_07)
        gameViewModel.drawableList.add(R.drawable.card_08)
        gameViewModel.drawableList.add(R.drawable.card_09)
        gameViewModel.drawableList.add(R.drawable.card_10)
        gameViewModel.drawableList.add(R.drawable.card_11)
        gameViewModel.drawableList.add(R.drawable.card_12)

    }
    // initial gameViewModel's buttonList from random pick
    private fun initButtonList(){

        var button00:ImageButton = findViewById(R.id.GameImageButton00)
        var button01:ImageButton = findViewById(R.id.GameImageButton01)
        var button02:ImageButton = findViewById(R.id.GameImageButton02)
        var button03:ImageButton = findViewById(R.id.GameImageButton03)

        var button10:ImageButton = findViewById(R.id.GameImageButton10)
        var button11:ImageButton = findViewById(R.id.GameImageButton11)
        var button12:ImageButton = findViewById(R.id.GameImageButton12)
        var button13:ImageButton = findViewById(R.id.GameImageButton13)

        var button20:ImageButton = findViewById(R.id.GameImageButton20)
        var button21:ImageButton = findViewById(R.id.GameImageButton21)
        var button22:ImageButton = findViewById(R.id.GameImageButton22)
        var button23:ImageButton = findViewById(R.id.GameImageButton23)

        var button30:ImageButton = findViewById(R.id.GameImageButton30)
        var button31:ImageButton = findViewById(R.id.GameImageButton31)
        var button32:ImageButton = findViewById(R.id.GameImageButton32)
        var button33:ImageButton = findViewById(R.id.GameImageButton33)

        var button40:ImageButton = findViewById(R.id.GameImageButton40)
        var button41:ImageButton = findViewById(R.id.GameImageButton41)
        var button42:ImageButton = findViewById(R.id.GameImageButton42)
        var button43:ImageButton = findViewById(R.id.GameImageButton43)

        var button50:ImageButton = findViewById(R.id.GameImageButton50)
        var button51:ImageButton = findViewById(R.id.GameImageButton51)
        var button52:ImageButton = findViewById(R.id.GameImageButton52)
        var button53:ImageButton = findViewById(R.id.GameImageButton53)
        gameViewModel.buttonList.add(button00)
        gameViewModel.buttonList.add(button01)
        gameViewModel.buttonList.add(button02)
        gameViewModel.buttonList.add(button03)

        gameViewModel.buttonList.add(button10)
        gameViewModel.buttonList.add(button11)
        gameViewModel.buttonList.add(button12)
        gameViewModel.buttonList.add(button13)

        gameViewModel.buttonList.add(button20)
        gameViewModel.buttonList.add(button21)
        gameViewModel.buttonList.add(button22)
        gameViewModel.buttonList.add(button23)

        gameViewModel.buttonList.add(button30)
        gameViewModel.buttonList.add(button31)
        gameViewModel.buttonList.add(button32)
        gameViewModel.buttonList.add(button33)

        gameViewModel.buttonList.add(button40)
        gameViewModel.buttonList.add(button41)
        gameViewModel.buttonList.add(button42)
        gameViewModel.buttonList.add(button43)

        gameViewModel.buttonList.add(button50)
        gameViewModel.buttonList.add(button51)
        gameViewModel.buttonList.add(button52)
        gameViewModel.buttonList.add(button53)
        initButtonDefault()
    }

    // initial all card button back to default: visiable and enabled
    private fun initButtonDefault(){
        for (button in gameViewModel.buttonList){
            setImageBack(button)
            button.isVisible = true
            button.isEnabled = true
        }
    }

    // set up the game
    private fun setUpGame(){
        // init
        gameViewModel.initGame()
        initButtonList()
        initDrawableList()
        initdrawableNameMap()

        // building random game
        while(gameViewModel.buttonList.isNotEmpty()){
            initialMap()
        }

        //countScoreTextView.text = gameViewModel.count.toString()
    }


    // when image button is clicked
    fun onCardButtonClick(view: View) {
        // when new round comes, flip previous pair back and enable
        if(gameViewModel.count.value!! > 0 && gameViewModel.isFirstClick() && !gameViewModel.found){
            setImageBack(gameViewModel.buttonFirstClick)
            setImageBack(gameViewModel.buttonSecondClick)
            gameViewModel.buttonFirstClick.isEnabled = true
            gameViewModel.buttonSecondClick.isEnabled = true
        }
        gameViewModel.found = false
        // if it is the first click of a round
        if(gameViewModel.isFirstClick()){
            // collect data for matching later
            gameViewModel.buttonFirstClick = findViewById(view.id)
            // get card front image
            val identifier = gameViewModel.imageButtonMap[gameViewModel.buttonFirstClick]!!
            // flip the card into the front image
            gameViewModel.buttonFirstClick.setImageResource(identifier)
            // increase count
            gameViewModel.onIncrementCount()
            // disabled in case duplicate click on the same button
            gameViewModel.buttonFirstClick.isEnabled = false
        }
        else{
            // if it is the second click of a round
            // collect data for matching
            gameViewModel.buttonSecondClick = findViewById(view.id)
            // check if it is a duplicate click
            // if not
            if(gameViewModel.buttonFirstClick != gameViewModel.buttonSecondClick) {
                // get card front image
                var identifier = gameViewModel.imageButtonMap[gameViewModel.buttonSecondClick]!!
                // flip the card
                gameViewModel.buttonSecondClick.setImageResource(identifier)
                // disabled in case duplicate click on the same button
                gameViewModel.buttonSecondClick.isEnabled = false
                // if matched
                if (gameViewModel.isMatched())
                {
                    gameViewModel.found = true
                    // set notification
                    matchNotification.setText(gameViewModel.drawableNameMap[identifier]!!)
                    // set delay
                    Handler().postDelayed({

                        // clear notification
                        matchNotification.setText("") }, 500)
                        // pop from map
                        gameViewModel.imageButtonMap.remove(gameViewModel.buttonFirstClick)
                        gameViewModel.imageButtonMap.remove(gameViewModel.buttonSecondClick)
                }

                gameViewModel.onIncrementCount()
            }
       }
        //countScoreTextView.text = gameViewModel.count.value.toString()
        if(gameViewModel.gameEnd()){
            showGameAlertDialog()
        }

    }

    private fun showGameAlertDialog(){
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setTitle(R.string.congrat)
            .setMessage("${gameViewModel.count.value}")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton(R.string.restart, DialogInterface.OnClickListener {
                    dialog, id -> setUpGame()
            })
            // negative button text and action
            .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // show alert dialog
        alert.show()
    }


}