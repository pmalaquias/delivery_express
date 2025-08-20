package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

/*import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okio.FileNotFoundException
import java.io.InputStream
import java.io.InputStreamReader*/

data class Estado(
    val sigla: String,
    val nome: String,
    val cidades: List<String>
)

data class States(val states: List<Estado>)

/*fun loadStatesFromJson(filePath: InputStream): List<Estado> {

    return try {
        //val json = File(filePath).readText()
        val statesType = object : TypeToken<States>() {}.type
        val states: States = Gson().fromJson(InputStreamReader(filePath), statesType)
        states.states
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
        emptyList()
    }catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}*/
