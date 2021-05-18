import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.tutorial.greentreeapp.R

class ProjectAdapter(private val context: Activity, private val imgId: Array<Int>, private val rating: Array<String>, private val designer: Array<String>)
    : ArrayAdapter<Int>(context, R.layout.item_project, imgId) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_project, null, true)

        val imageView = rowView.findViewById(R.id.projectPhoto) as ImageView
        val ratingText = rowView.findViewById(R.id.projectRatingBody) as TextView
        val authorText = rowView.findViewById(R.id.projectAuthorBody) as TextView

        imageView.setImageResource(imgId[position])
        ratingText.text = rating[position]
        authorText.text = designer[position]

        return rowView
    }
}