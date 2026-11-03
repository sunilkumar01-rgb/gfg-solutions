class Solution {
  public:
    Node *first = nullptr, *middle = nullptr, *last = nullptr;
    Node *prev = nullptr;

    void inorder(Node* root) {
        if (root == nullptr) return;

        inorder(root->left);

        if (prev != nullptr && prev->data > root->data) {
            if (first == nullptr) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root->right);
    }

    Node* correctBST(Node* root) {
        first = middle = last = prev = nullptr;

        inorder(root);

        if (last != nullptr) {
            swap(first->data, last->data);
        } 
        else if (first != nullptr) {
            swap(first->data, middle->data);
        }

        return root;
    }
};