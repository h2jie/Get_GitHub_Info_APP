package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private List<Repo> repoList;

    public RepoAdapter(List<Repo> repoList) {
        this.repoList = repoList;
    }
    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.RepoViewHolder holder, int position) {

        Repo repo = repoList.get(position);
        if (repo !=null){
            holder.nameTextView.setText(repo.getName());
            holder.descriptionTextView.setText(repo.getDescription() != null ? repo.getDescription() : "No description");
            holder.started.setText("Stars: " + repo.getStargazers_count());
        }

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }
    static class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        TextView started;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.repo_name);
            descriptionTextView = itemView.findViewById(R.id.repo_description);
            started = itemView.findViewById(R.id.stargazers_count);
        }
    }
}
