import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomnoteapp.MainActivity
import com.example.roomnoteapp.Note
import com.example.roomnoteapp.databinding.SingleitemBinding
import com.example.roomnoteapp.fragment_note


class MyAdapter(val Fragment: fragment_note, var Notes: List<Note>) :
    RecyclerView.Adapter<MyAdapter.viewItemHolder>() {
    class viewItemHolder(val binding: SingleitemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewItemHolder {
        return viewItemHolder(
            SingleitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: viewItemHolder, position: Int) {
        var note = Notes[position]

        holder.binding.apply {
            textView.text = note.Notetitle
            imupdate.setOnClickListener {
              //  update(note)
                with(Fragment.sh.edit()) {
                    putInt("ID", note.id)
                    apply()
                }
                Fragment.gotoupdate()// there will be function for update
//                activity.update(note)
            }
            imdelete.setOnClickListener {
                Fragment.deletenote(note)
//            }
            }
        }
    }


    override fun getItemCount() = Notes.size
    fun updateMyAdapter(notes: List<Note>) {
        this.Notes = notes
        notifyDataSetChanged()
    }


}

