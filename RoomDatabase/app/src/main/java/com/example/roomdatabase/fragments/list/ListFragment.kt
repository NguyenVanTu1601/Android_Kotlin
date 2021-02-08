package com.example.roomdatabase.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.R
import com.example.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_list, container, false)

        // recycler view
        var adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // user view model
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // mUserViewMode.readAllData là 1 LiveData nên có thể gọi obserrve
        // khi observe được gọi, nó sẽ kiểm tra xem lifecle của chủ nó Owner còn sống hay ko
        // nếu sống thì nó đẩy users vào và cho phép cập nhật
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { users->
            adapter.setData(users)

        })

        // add menu
        setHasOptionsMenu(true)

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delet_item){
            deleteAllUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUser() {
        var builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete all users ?")
        builder.setMessage("You are want to delete all users")
        builder.setNegativeButton("No"){_,_ ->
        }
        builder.setPositiveButton("Yes"){_,_->
            mUserViewModel.deleteAllUsers()
            Toast.makeText(requireContext(), "Success delete all user",
                Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
}