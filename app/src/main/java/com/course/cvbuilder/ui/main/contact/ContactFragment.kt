package com.course.cvbuilder.ui.main.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.course.cvbuilder.R


/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_contact, container, false)

        v.findViewById<LinearLayout>(R.id.phone).setOnClickListener{
            makeCall()
        }
        v.findViewById<LinearLayout>(R.id.linkedIn).setOnClickListener{
            browseWebsite("https://www.linkedin.com/in/mahmoud-anwar-fadel/")
        }

        v.findViewById<LinearLayout>(R.id.github).setOnClickListener{
            browseWebsite("https://github.com/MahmoudAnwar613725")
        }
        v.findViewById<LinearLayout>(R.id.email).setOnClickListener{
            sendEmail()
         }
        return v
    }

    fun onContactClick(view: View){
        when(view.id){
            R.id.phone->{

            }
            R.id.linkedIn->{

                browseWebsite("https://www.linkedin.com/in/mahmoud-anwar-fadel/")
            }
            R.id.github->{
                browseWebsite("https://github.com/MahmoudAnwar613725")
            }
            R.id.email->{
                sendEmail()
            }
        }

    }


    private fun makeCall() {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "8344814819")
        startActivity(dialIntent)
    }



    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, "mhmodu@muy.edu")
        intent.putExtra(Intent.EXTRA_SUBJECT, "open vacancy")
        startActivity(intent)
    }

    private fun browseWebsite(website: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(browserIntent);
    }


}