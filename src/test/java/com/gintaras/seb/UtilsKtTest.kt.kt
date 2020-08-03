package com.gintaras.seb

import com.gintaras.seb.model.Questionnaire
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/*
 * @created 03/08/2020 - 13:57
 * @author gintaras
 */

class UtilsKtTest {

    @Test
    fun `method correctly determines possible products if age less then 17`() {
        val questionnaire = Questionnaire(AGE_0_17, null, null)
        val value = determinePossibleProduct(questionnaire)
        assertEquals(listOf(PRODUCT_JUNIOR_SAVER_ACCOUNT), value)
    }

    @Test
    fun `method correctly determines possible products if age gt 65 and income gt 40000`() {
        val questionnaire = Questionnaire(AGE_65_, null, INCOME_40001_)
        val value = determinePossibleProduct(questionnaire)
        assertEquals(listOf(
                PRODUCT_SENIOR_ACCOUNT
                ,PRODUCT_CURRENT_ACCOUNT
                ,PRODUCT_CURRENT_ACCOUNT_PLUS
                ,PRODUCT_GOLD_CREDIT_CARD), value)
    }

    @Test
    fun `method correctly determines possible products if age gt 17 and income gt 12000`() {
        val questionnaire = Questionnaire(AGE_18_64, null, INCOME_12001_40000)
        val value = determinePossibleProduct(questionnaire)
        assertEquals(listOf(PRODUCT_CURRENT_ACCOUNT), value)
    }

    @Test
    fun `method correctly determines possible products if age gt 17 and is student`() {
        val questionnaire = Questionnaire(AGE_18_64, STUDENT_YES, null)
        val value = determinePossibleProduct(questionnaire)
        assertEquals(listOf(PRODUCT_STUDENT_ACCOUNT), value)
    }

}
