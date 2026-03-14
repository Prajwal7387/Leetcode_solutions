void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int nums[m+n];
    int i=0,j=0,k=0;
    while (i<m&&j<n)
    {
        if(nums1[i]<nums2[j])
        {
            nums[k]=nums1[i];
            k++;
            i++;
        }
        else{
            nums[k]=nums2[j];
            k++;
            j++;
        }
    }
    while(i<m)
    {
        nums[k]=nums1[i];
        k++;
        i++;    
        }

        while(j<n)
        {
             nums[k]=nums2[j];
            k++;
            j++;
        }    
        for(int i=0;i<m+n;i++)
        {
            nums1[i]=nums[i];
        }
    
}