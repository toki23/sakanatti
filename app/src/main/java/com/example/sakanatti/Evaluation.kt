package com.example.sakanatti

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Evaluation : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(EvaluationModel::class.java)
    }

    private lateinit var listener1: RadioGroup.OnCheckedChangeListener
    private lateinit var listener2: RadioGroup.OnCheckedChangeListener
    private lateinit var listener3: RadioGroup.OnCheckedChangeListener
    private lateinit var listener4: RadioGroup.OnCheckedChangeListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluation)

        radioSetting(R.id.radioGroup11, R.id.radioGroup12, 1)
        radioSetting(R.id.radioGroup21, R.id.radioGroup22, 2)
        radioSetting(R.id.radioGroup31, R.id.radioGroup32, 3)
        radioSetting(R.id.radioGroup41, R.id.radioGroup42, 4)
        viewModel.evaluation.observe(this) {
            it.forEach { element ->
                if (element.id != 0) {
                    findViewById<RadioButton>(element.id).isChecked = true
                }
            }
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            val s1: Int = viewModel.evaluation.value?.get(0)?.value ?: 0
            val s2: Int = viewModel.evaluation.value?.get(1)?.value ?: 0
            val s3: Int = viewModel.evaluation.value?.get(2)?.value ?: 0
            val s4: Int = viewModel.evaluation.value?.get(3)?.value ?: 0
            Database.insert(applicationContext, s1, s2, s3, s4)
        }
    }

    private fun radioSetting(radio1: Int, radio2: Int, id: Int) {
        val radioGroup1 = findViewById<RadioGroup>(radio1)
        val radioGroup2 = findViewById<RadioGroup>(radio2)
        val listener: RadioGroup.OnCheckedChangeListener =
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radioButton11, R.id.radioButton21, R.id.radioButton31, R.id.radioButton41 -> {
                        viewModel.setEvaluation(checkedId, 5, id - 1)
                    }
                    R.id.radioButton12, R.id.radioButton22, R.id.radioButton32, R.id.radioButton42 -> {
                        viewModel.setEvaluation(checkedId, 3, id - 1)
                    }
                    R.id.radioButton13, R.id.radioButton23, R.id.radioButton33, R.id.radioButton43 -> {
                        viewModel.setEvaluation(checkedId, 1, id - 1)
                    }
                    R.id.radioButton14, R.id.radioButton24, R.id.radioButton34, R.id.radioButton44 -> {
                        viewModel.setEvaluation(checkedId, 4, id - 1)
                    }
                    R.id.radioButton15, R.id.radioButton25, R.id.radioButton35, R.id.radioButton45 -> {
                        viewModel.setEvaluation(checkedId, 2, id - 1)
                    }
                    R.id.radioButton16, R.id.radioButton26, R.id.radioButton36, R.id.radioButton46 -> {
                        viewModel.setEvaluation(checkedId, 6, id - 1)
                    }
                }
                if (checkedId != -1) when (group.id) {
                    radio1 -> checkAnswer(radioGroup2, id)
                    radio2 -> checkAnswer(radioGroup1, id)
                }
            }
        when (id) {
            1 -> {
                listener1 = listener
                radioGroup1.setOnCheckedChangeListener(listener1)
                radioGroup2.setOnCheckedChangeListener(listener1)
            }
            2 -> {
                listener2 = listener
                radioGroup1.setOnCheckedChangeListener(listener2)
                radioGroup2.setOnCheckedChangeListener(listener2)
            }
            3 -> {
                listener3 = listener
                radioGroup1.setOnCheckedChangeListener(listener3)
                radioGroup2.setOnCheckedChangeListener(listener3)
            }
            4 -> {
                listener4 = listener
                radioGroup1.setOnCheckedChangeListener(listener4)
                radioGroup2.setOnCheckedChangeListener(listener4)
            }
        }
    }

    private fun checkAnswer(radioGroup: RadioGroup, id: Int) {
        radioGroup.setOnCheckedChangeListener(null)
        radioGroup.clearCheck()
        when (id) {
            1 -> radioGroup.setOnCheckedChangeListener(listener1)
            2 -> radioGroup.setOnCheckedChangeListener(listener2)
            3 -> radioGroup.setOnCheckedChangeListener(listener3)
            4 -> radioGroup.setOnCheckedChangeListener(listener4)
        }
    }
}

data class EvaluationType(val id: Int, val value: Int)

class EvaluationModel : ViewModel() {
    private var evaluationValue = mutableListOf(
        EvaluationType(0, 0),
        EvaluationType(0, 0),
        EvaluationType(0, 0),
        EvaluationType(0, 0),
    )
    private val _evaluation = MutableLiveData<List<EvaluationType>>()
    val evaluation: LiveData<List<EvaluationType>> get() = _evaluation
    fun setEvaluation(id: Int, value: Int, index: Int) {
        evaluationValue[index] = EvaluationType(id = id, value = value)
        _evaluation.value = evaluationValue
    }
}