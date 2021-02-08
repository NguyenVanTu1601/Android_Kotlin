package com.example.roomdatabase.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdatabase.R
import com.example.roomdatabase.model.User
import com.example.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import java.util.zip.Inflater

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewMode : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        // viewmodel
        mUserViewMode = ViewModelProvider(this).get(UserViewModel::class.java)

        // show user
        view.upFirstName_et.setText(args.currentUser.firstName)
        view.upLastName_et.setText(args.currentUser.lastName)
        view.upAge_et.setText(args.currentUser.age.toString())

        view.up_button.setOnClickListener { it->
            updateItem()

        }

        // add menu
        setHasOptionsMenu(true)


        return view
    }

    private fun updateItem(){
        var firtName = upFirstName_et.text.toString()
        var lastName = upLastName_et.text.toString()
        var age = upAge_et.text

        if (inputCheck(firtName,lastName,age)){
            // add User to Object
            var updateUser = User(args.currentUser.id,firtName,lastName,Integer.parseInt(age.toString()))

            // update
            mUserViewMode.updateUser(updateUser)
            Toast.makeText(requireContext(),"Update Success!",Toast.LENGTH_SHORT).show()
            // nav back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName : String, lastName : String, age : Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delet_item){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        var builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete ${args.currentUser.firstName} ?")
        builder.setMessage("You are want to delete ${args.currentUser.firstName}")
        builder.setNegativeButton("No"){_,_ ->


        }
        builder.setPositiveButton("Yes"){_,_->
            mUserViewMode.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Success delete user : ${args.currentUser.firstName}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.create().show()

    }
}