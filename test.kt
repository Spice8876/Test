1. 액티비티 만들기
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        2. 컨텐트 뷰
        setContentView(R.layout.activity_main)


        3. 위젯 불러오기
        val button = findViewById<Button>(R.id.button01)


        4. 버튼 콜백 달기
        button.setOnClickListener{}


        5. 라디오 버튼 다루기
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioA = findViewById<RadioButton>(R.id.radioA)
        val radioB = findViewById<RadioButton>(R.id.radioB)

        fun onClick(){
            when(radioGroup.checkedRadioButtonId){
                R.id.radioA -> textView.text = radioDog.radioA
                R.id.radioB -> textView.text = radioCat.radioA
            }
        }


        7. 암시적 인텐트 만들기
        val implicitIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))


        8. 명시적 인텐트 만들기
        val intent = Intent(this, SecondActivity::class.java)


        9. 인텐트에 데이터 집어 넣기
        intent.putExtra("name" , "data")


        10. 인텐트 받는 액티비티 시작하기
        activityResult.launch(intent)


        11. 엑티비티 결과 받기
        var activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            var msg = it.data?.getStringExtra("")?: ""
        }
    }
}

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        12. 시작시 액티비티 결과 받기
        var msg = intent?.getStringExtra("name")?: ""


        #. 그냥 뷰모델 만들기
        val model = ViewModelProvider(this)[MyViewModel::class.java]


        #. 팩토리 뷰모델 만들기
        val model = ViewModelProvider(this , MyViewModelFactory(10))[MyViewModel::class.java]
        

        #. 라이브데이터 리스너 추가
        model.liveData.observe(this){

        }


        16. 백버튼 디스패처
        onBackPressedDispatcher.addCallback(this , object : OnBackPressedCallback(true){
            #. 결과
            setResult(RESULT_OK , reusltIntent)
            finish()
        })
    }
}

13. 뷰모델 정의하기
class MyViewModel(count: Int) : ViewModel() {
    
    15. 라이브데이터
    val liveData = MutableLiveData<Int>()
    
}

14. 뷰모델 팩토리
class MyViewModelFactory(private val count: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MyViewModel(count) as T
    }
}
