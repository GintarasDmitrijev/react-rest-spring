package com.gintaras.seb

import com.gintaras.seb.model.Questionnaire

const val AGE_0_17 = "0-17"
const val AGE_18_64 = "18-64"
const val AGE_65_ = "65+"
const val STUDENT_YES = "Yes"
const val INCOME_0 = "0"
const val INCOME_1_12000 = "1-12000"
const val INCOME_12001_40000 = "12001-40000"
const val INCOME_40001_ = "40001+"

const val PRODUCT_CURRENT_ACCOUNT = "Current Account"
const val PRODUCT_CURRENT_ACCOUNT_PLUS = "Current Account Plus"
const val PRODUCT_JUNIOR_SAVER_ACCOUNT = "Junior Saver Account"
const val PRODUCT_STUDENT_ACCOUNT = "Student Account"
const val PRODUCT_SENIOR_ACCOUNT = "Senior Account"
const val PRODUCT_DEBIT_CARD = "Debit Card"
const val PRODUCT_CREDIT_CARD = "Credit Card"
const val PRODUCT_GOLD_CREDIT_CARD = "Gold Credit Card"

const val NO_PRODUCTS_MESSAGE = "No suitable products"

val AGE_GT_17_LIST = listOf<String>(AGE_18_64, AGE_65_)

val imageMap = mapOf<String, String>(PRODUCT_CURRENT_ACCOUNT
        to "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/greek-style_chicken_and_64546_16x9.jpg",
        PRODUCT_CURRENT_ACCOUNT_PLUS
                to "https://www.bbcgoodfood.com/sites/default/files/recipe-collections/" +
                "collection-image/2013/05/meatball-lasagne.jpg",
        PRODUCT_JUNIOR_SAVER_ACCOUNT
                to "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/" +
                "broccoli-cauliflower-gratin-1571073579.jpg",
        PRODUCT_STUDENT_ACCOUNT
                to "https://hips.hearstapps.com/del.h-cdn.co/assets/17/36/1504715616-delish-fettucine-alfredo-1.jpg",
        PRODUCT_SENIOR_ACCOUNT
                to "https://sweetpeasandsaffron.com/wp-content/uploads/2019/04/caprese-chicken-pasta-bake-4.jpg",
        PRODUCT_DEBIT_CARD
                to "https://littlespicejar.com/wp-content/uploads/2014/07/Spicy-Baked-Caprese-Pasta-13-719x1024.jpg",
        PRODUCT_CREDIT_CARD
                to "https://www.theseasonedmom.com/wp-content/uploads/2017/03/Dump-and-Bake-Chicken-Caprese-Pasta-5.jpg",
        PRODUCT_GOLD_CREDIT_CARD
                to "https://www.yellowblissroad.com/wp-content/uploads/2016/08/Caprese-Chicken3.jpg",

        NO_PRODUCTS_MESSAGE to "https://actlearnlead.files.wordpress.com/2012/12/empty-box.jpg?w=500",
)

/**
 * Utility function that determines which product or products are suitable for the user according to
 * information gathered.
 */
fun determinePossibleProduct(questionnaire: Questionnaire) : List<String> =
        when {

            //Junior Saver Account
            questionnaire.age.equals(AGE_0_17) -> listOf(PRODUCT_JUNIOR_SAVER_ACCOUNT)
            //Senior Account
            questionnaire.age.equals(AGE_65_)
                    && questionnaire.income.equals(INCOME_0) -> listOf(PRODUCT_SENIOR_ACCOUNT
                                                                ,PRODUCT_DEBIT_CARD)
            questionnaire.age.equals(AGE_65_)
                    && questionnaire.income.equals(INCOME_40001_) -> listOf(
                     PRODUCT_SENIOR_ACCOUNT
                    ,PRODUCT_CURRENT_ACCOUNT
                    ,PRODUCT_CURRENT_ACCOUNT_PLUS
                    ,PRODUCT_GOLD_CREDIT_CARD)

            //Current Account
            questionnaire.income in listOf<String>(INCOME_12001_40000)
                    && questionnaire.age in AGE_GT_17_LIST -> listOf(PRODUCT_CURRENT_ACCOUNT)

            //Current Account +
            questionnaire.income in listOf<String>(INCOME_1_12000,INCOME_12001_40000)
                    && questionnaire.age in AGE_GT_17_LIST -> listOf(PRODUCT_CURRENT_ACCOUNT
                                                                    ,PRODUCT_DEBIT_CARD)
            //Debit Card
            questionnaire.income.equals(INCOME_0)
                    && questionnaire.age in AGE_GT_17_LIST -> listOf(PRODUCT_DEBIT_CARD)

            //Current Account + Current Account Plus + Gold Credit Card
            questionnaire.income.equals(INCOME_40001_)
                    && questionnaire.age in AGE_GT_17_LIST -> listOf(PRODUCT_CURRENT_ACCOUNT
                                                                    ,PRODUCT_CURRENT_ACCOUNT_PLUS
                                                                    ,PRODUCT_GOLD_CREDIT_CARD)
            //Student Account
            questionnaire.student.equals(STUDENT_YES)
                    && questionnaire.age in AGE_GT_17_LIST -> listOf(PRODUCT_STUDENT_ACCOUNT)


            else -> listOf(NO_PRODUCTS_MESSAGE)
        }

/**
 * Resolves image url to display along with the product.
 */
fun resolveProductCover(name: String) = imageMap.get(name)

