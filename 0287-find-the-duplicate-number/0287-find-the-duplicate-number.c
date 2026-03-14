int findDuplicate(int* nums, int numsSize) {
    int hash[numsSize+1];
    for(int i=0;i<numsSize;i++)
    {
        hash[i]=0;
    }
    for(int i=0;i<numsSize;i++)
    {
        hash[nums[i]]++;
        if(hash[nums[i]]==2){return nums[i];}
    }
    return -1;
}