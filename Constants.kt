package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_SOAL: String = "total_soal"
    const val CORRECT_ANSWER: String = "correct_answer"


    fun getSoal(): ArrayList<Soal>{
        val soalList = ArrayList<Soal>()

        val soal1 = Soal(1, "Siapakah nama tokoh di bawah ini?",
            R.drawable.ic_jackdorsey,
            "mark zuckerberg",
            "bill gates",
            "jack ma",
            "jack dorsey",
            4
        )
        soalList.add(soal1)

        //2
        val soal2 = Soal(2, "Siapakah nama tokoh tersebut?",
            R.drawable.ic_billgates,
            "jack ma",
            "bill gates",
            "mark zuckerberg",
            "J.K. Rowling",
            2
        )
        soalList.add(soal2)

        //3
        val soal3 = Soal(3, "Siapakah nama tokoh tersebut?",
            R.drawable.ic_stevejobs,
            "steve jobs",
            "J.K. Rowling",
            "mark zuckerberg",
            "bill gates",
            1
        )
        soalList.add(soal3)

        //4
        val soal4 = Soal(4, "Siapakah nama tokoh tersebut?",
            R.drawable.ic_jackma,
            "steve jobs",
            "jack ma",
            "mark zuckerberg",
            "bill gates",
            2
        )
        soalList.add(soal4)

        //5
        val soal5 = Soal(5, "Siapakah nama tokoh tersebut?",
            R.drawable.ic_dosan,
            "han ji-pyeong",
            "lee chu-san",
            "nam do-san",
            "nam do-han",
            3
        )

        soalList.add(soal5)
        return soalList
    }
}